/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author EstudianteLIS
 */
public class WebPages {
    private int index;
    private String pageID;
    private String url;
    private String pageTitle;
    private String pageText;
    private String extractionTask;
    
    public WebPages(String index1, String pageID1, String url1, String pageTitle1, String pageText1, String extractionTask1){ 
    }

    public WebPages(int index, String pageID, String url, String pageTitle, String pageText, String extractionTask) {
        this.index = index;
        this.pageID = pageID;
        this.url = url;
        this.pageTitle = pageTitle;
        this.pageText = pageText;
        this.extractionTask = extractionTask;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getPageID() {
        return pageID;
    }

    public void setPageID(String pageID) {
        this.pageID = pageID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getPageText() {
        return pageText;
    }

    public void setPageText(String pageText) {
        this.pageText = pageText;
    }

    public String getExtractionTask() {
        return extractionTask;
    }
    public void setExtractionTask(String extractionTask) {
        this.extractionTask = extractionTask;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WebPages{");
        sb.append("index=").append(index);
        sb.append(", pageID=").append(pageID);
        sb.append(", url=").append(url);
        sb.append(", pageTitle=").append(pageTitle);
        sb.append(", pageText=").append(pageText);
        sb.append(", extractionTask=").append(extractionTask);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
