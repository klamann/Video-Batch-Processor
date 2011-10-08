/*
 * Copyright (C) 2011 Sebastian Straub <sebastian-straub@gmx.net>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package vbp.model;

import vbp.model.export.HandbrakeExport;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import sebi.util.data.ListUtils;
import sebi.util.observer.EventArgs;

/**
 * The Model class holds the main program logic. All user settings are stored
 * here and every action is executed from here.
 * 
 * @author Sebastian Straub <sebastian-straub@gmx.net>
 */
public class Model {
    
    // <editor-fold desc="Class attributes">
    
    // Model
    protected Crawler crawler = new Crawler();
    
    // GUI
    // main view
    protected List<File> filesToTranscode = new ArrayList<File>();
    
    // input
    protected List<File> inputFiles = new ArrayList<File>();
    protected boolean recursive;
    
    // output
    protected OutputMethod outputMethod;
    protected String renamePattern;
    protected boolean preserveFolders;
    protected File outputLocation = null;
    
    // search pattern
    protected SearchPattern searchPattern;
    protected boolean fileSize;
    protected boolean fileExtension;
    protected long minSize;
    protected long maxSize;
    protected String extensionFilter;
    protected String regex;
    
    // encoding
    protected String handBrakeQuery;
    
    // </editor-fold>
    
    public Model() {
        // unused
    }
    
    /**
     * Writes inital values. Must be called after the model was constructed
     * (can not reference model while construction is is progress)
     */
    public void init() {
        Settings.loadSettings(this);
    }
    
    // ------------- load and save -------------
    
    /**
     * loads the default configuration. Shall be called when no user configuration
     * is available or the user specifically requests this from gui.
     */
    public void loadDefaults() {
        Settings.loadDefaultSettings(this);
        filesToTranscode = new ArrayList<File>();
        inputFiles = new ArrayList<File>();
    }
    
    /**
     * Loads a saved project file
     * @param fileChooser the file selection dialogue to be opened
     */
    public void loadProject(JFileChooser fileChooser) {
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            Settings.loadProject(this, fileChooser.getSelectedFile());
            updateGUI.fire(GuiComponents.LIST_INPUT);
            updateGUI.fire(GuiComponents.LIST_TRANSCODE);
        }
    }
    
    /**
     * Saves the current project to a user selected location
     * @param fileChooser the file selection dialogue to be opened
     */
    public void saveProject(JFileChooser fileChooser) {
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            Settings.writeProject(this, fileChooser.getSelectedFile());
        }
    }
    
    // ------------- main view -------------
    
    public void clearFilesToTranscode() {
        filesToTranscode.clear();
        updateGUI.fire(GuiComponents.LIST_TRANSCODE);
    }
    
    public void moveFilesToTranscodeUp(File file) {
        // TODO
    }
    
    public void moveFilesToTranscodeDown(File file) {
        // TODO
    }
    
    public void removeFilesToTranscode(String[] files) {
        // TODO
    }
    
    public void removeFilesToTranscode(List<File> files) {
        // TODO
    }
    
    public void updateFilesToTranscode() {
        // TODO this is very inefficient! improve!
        filesToTranscode = crawler.crawlComplete(inputFiles, recursive, FileFilter.initialize(this));
        
        updateGUI.fire(GuiComponents.LIST_TRANSCODE);
    }
    
    /**
     * @return all files that shall be transcoded
     */
    public List<String> getFilesToTranscode() {
        return filesToCanocialPath(filesToTranscode);
    }
    
    // ------------- input -------------
    
    public void addInputFiles(File[] files) {
        addInputFiles(ListUtils.listOfArray(files));
    }
    
    public void addInputFiles(List<File> files) {
        for (File file : files) {
            if(!inputFiles.contains(file))
                inputFiles.add(file);
        }
        
        filesToTranscode = crawler.crawlComplete(inputFiles, recursive, FileFilter.initialize(this));
        
        updateGUI.fire(GuiComponents.LIST_INPUT);
        updateGUI.fire(GuiComponents.LIST_TRANSCODE);
    }
    
    public void moveInputFileUp(File file) {
        // TODO
    }
    
    public void moveInputFileDown(File file) {
        // TODO
    }
    
    public void removeInputFiles(String[] files) {
        List<File> list = new ArrayList<File>(files.length);  
        for (String fileString : files) {
            list.add(new File(fileString));
        }
        removeInputFiles(list);
    }
    
    public void removeInputFiles(List<File> files) {
        inputFiles.removeAll(files);
        updateGUI.fire(GuiComponents.LIST_INPUT);
        
        updateFilesToTranscode();
    }
    
    public void clearInputFiles() {
        inputFiles.clear();
        updateGUI.fire(GuiComponents.LIST_INPUT);
    }
    
    public List<String> getInputFiles() {
        return filesToCanocialPath(inputFiles);
    }
    
    // ------------- export -------------
    
    public void exportToHandbrake(JFileChooser fileChooser) {
        
        // get current query and renamepattern
        // throw fail events to gui (separate) when items are malformed
        
        HandbrakeExport.saveQueue(fileChooser, filesToTranscode, handBrakeQuery, renamePattern);
    }
    
    // ------------- general -------------
    
    /**
     * Asks the user to save his changes before he leaves the program,
     * if any changes have been done
     */
    public void safeExit() {
        
        Settings.writeSettings(this);
        
        // TODO show save dialogue as soon as saving is possible...
        
        System.exit(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Event-block + Getters">
    
    protected EventArgs<GuiComponents> updateGUI = new EventArgs<GuiComponents>();

    /**
     * @return a request from the model to update a specific gui-element.
     */
    public EventArgs<GuiComponents> eventUpdateGUI() {
        return updateGUI;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="generated Getters and Setters">

    /**
     * @return all file extensions that can pass the filter as comma-separated values
     */
    public String getExtensionFilter() {
        return extensionFilter.replace('|', ',');
    }

    /**
     * @param extensionFilter all file extensions that can pass the filter as comma-separated values
     */
    public void setExtensionFilter(String extensionFilter) {
        this.extensionFilter = extensionFilter.toLowerCase().replaceAll(" ", "").replace(',', '|');
    }
    
    /**
     * @return filter file extensions?
     */
    public boolean getFileExtension() {
        return fileExtension;
    }

    /**
     * @param fileExtension filter file extensions?
     */
    public void setFileExtension(boolean fileExtension) {
        this.fileExtension = fileExtension;
    }

    /**
     * @return filter file size?
     */
    public boolean getFileSize() {
        return fileSize;
    }
    
    /**
     * @param fileSize filter file size?
     */
    public void setFileSize(boolean fileSize) {
        this.fileSize = fileSize;
    }
    
    /**
     * @return handbrake-query, that will be used to generate the queue-file
     */
    public String getHandBrakeQuery() {
        return handBrakeQuery;
    }
    
    /**
     * @param handBrakeQuery handbrake-query, that will be used to generate the queue-file
     */
    public void setHandBrakeQuery(String handBrakeQuery) {
        // remove -i and -o parameters
        this.handBrakeQuery = removeArgFromString(handBrakeQuery, "-i", "-o");
    }

    /**
     * @return upper file size limit used when the size filter is enabled (see setFileSize())
     */
    public int getMaxSize() {
        return (int) (maxSize / 1048576);
    }

    /**
     * @param maxSize upper file size limit used when the size filter is enabled (see setFileSize())
     */
    public void setMaxSize(int maxSize) {
        this.maxSize = ((long) maxSize) * 1048576l;
    }

    /**
     * @return lower file size limit used when the size filter is enabled (see setFileSize())
     */
    public int getMinSize() {
        return (int) (minSize / 1048576);
    }

    /**
     * @param minSize lower file size limit used when the size filter is enabled (see setFileSize())
     */
    public void setMinSize(int minSize) {
        this.minSize = ((long) minSize) * 1048576l;
    }

    /**
     * @return location where files will be saved when using a different folder
     */
    public String getOutputLocation() {
        if (outputLocation != null) {
            try {
                return outputLocation.getCanonicalPath();
            } catch (IOException ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "";
    }

    /**
     * @param outputLocation location where files will be saved when using a different folder
     */
    public void setOutputLocation(File outputLocation) {
        this.outputLocation = outputLocation;
    }

    /**
     * Saves transcoded files in the same folder as the original ones, using a
     * rename pattern to avoid file conflicts
     */
    public void setOutputSamePlace() {
        this.outputMethod = OutputMethod.INPLACE;
    }
    
    /**
     * Saves transcoded files in a specified folder.
     */
    public void setOutputDifferentFolder() {
        this.outputMethod = OutputMethod.SPECIFIC_FOLDER;
    }
    
    public boolean isOutputSamePlace() {
        return (outputMethod == OutputMethod.INPLACE);
    }
    
    public boolean isOutputDifferentFolder() {
        return (outputMethod == OutputMethod.SPECIFIC_FOLDER);
    }
    
    public boolean getPreserveFolders() {
        return preserveFolders;
    }

    /**
     * @param preserveFolders preserve the folder structure, when saving files
     *        in a different location?
     */
    public void setPreserveFolders(boolean preserveFolders) {
        this.preserveFolders = preserveFolders;
    }
    
    public boolean isRecursive() {
        return recursive;
    }

    /**
     * @param recursive search folders recursively (with subfolders)
     */
    public void setRecursive(boolean recursive) {
        this.recursive = recursive;
    }

    /**
     * @return the custom regex that will be applied to filter files
     */
    public String getRegex() {
        return regex;
    }

    /**
     * @param regex the custom regex that will be applied to filter files
     */
    public void setRegex(String regex) {
        this.regex = regex;
    }

    /**
     * @return the rename pattern that will be used when files are saved in-place
     */
    public String getRenamePattern() {
        return renamePattern;
    }

    /**
     * @param renamePattern the rename pattern that will be used when files are saved in-place
     */
    public void setRenamePattern(String renamePattern) {
        this.renamePattern = renamePattern;
    }

    /**
     * @return the locations or files where the program is searching for files to transcode
     */
    public List<File> getSearchPath() {
        return inputFiles;
    }
    
    /**
     * Use the built-in file properties dialogue to generate your filter
     */
    public void setSearchPatternProperties() {
        searchPattern = SearchPattern.FILE_PROPERTIES;
    }
    
    /**
     * Use a custom regex to build your filter
     */
    public void setSearchPatternRegex() {
        searchPattern = SearchPattern.REGEX;
    }
    
    public boolean isSearchPatternProperties() {
        return (searchPattern == SearchPattern.FILE_PROPERTIES);
    }
    
    public boolean isSearchPatternRegex() {
        return (searchPattern == SearchPattern.REGEX);
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="enum-block">
    
    protected enum OutputMethod {
        INPLACE,
        SPECIFIC_FOLDER;
    }

    protected enum SearchPattern {
        FILE_PROPERTIES,
        REGEX;
    }
    
    public enum GuiComponents {
        LIST_TRANSCODE,
        LIST_INPUT,
        RENAME_PATTERN,
        DIFFERENT_FOLDER,
        PATTERN_SIZE_MIN,
        PATTERN_SIZE_MAX,
        PATTERN_EXTENSIONS,
        PATTERN_REGEX,
        HANDBRAKE_QUERY;
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="static methods">
    
    public static List<String> filesToCanocialPath(List<File> files) {
        List<String> list = new ArrayList<String>();
        for (File file : files) {
            try {
                list.add(file.getCanonicalPath());
            } catch (IOException ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    
    /**
     * <p>This is a very specialized function to remove certain parts from a command
     * line. For any substring that shall be removed from the command line (e.g. -i)
     * this function also removes the statement after this argument included in
     * quotation marks (e.g. "/home/folder/file.txt").</p>
     * 
     * <p>So, calling <code>removeArgFromString(input, "-i");</code> for the input string
     * <code>-f -i "/home/folder/file.txt" -g 100 ...</code> returns <code>-f  -g 100 ...</code>
     * (note that the double whitespace after -f remains preserved)</p>
     * 
     * <p>This function can cause unexpected behaviour when called on Strings that
     * don't follow the schema: <code>arg "content to this arg"</code>.</p>
     * 
     * @param input file string to remove command line args from
     * @param args command line arguments to remove from the string
     * @return same string without the args and subsequent expressions in quotation marks.
     */
    public static String removeArgFromString(String input, String... args) {
        
        for (String arg : args) {
            if (input.contains(arg)) {
                int argBegin = input.indexOf(arg);          // find argument
                int argEnd = nthIndexOf(input, '\"', argBegin, 2) + 1;

                StringBuilder removed = new StringBuilder(input.length());
                removed.append(input.substring(0, argBegin));
                removed.append(input.substring(argEnd));

                input = removed.toString();
            }
        }
        
        return input;
    }
    
    /**
     * Returns the nth appearance of a specified char inside a String. Good if you want
     * to find the position of matching characters like quotation marks or brackets.
     * @param input String to search in
     * @param match Character to find
     * @param fromIndex Index position to start the search
     * @param nth which occurance to return
     * @return index of the nth appearance of the specified char
     */
    public static int nthIndexOf(String input, char match, int fromIndex, int nth) {
        
        int tmpIndex = fromIndex;
        for (int i = 0; i < nth; i++) {
            tmpIndex = input.indexOf(match, tmpIndex+1);
        }
        
        return tmpIndex;
    }
    
    // </editor-fold>
    
}
