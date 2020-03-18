package heritage.restful.model;


import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "pages")
public class Pages {
    @Id
    @Column(name="pageid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pageId;
    @Column(name="title")
    private String title;
    @Column(name="content")
    private String content;

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
