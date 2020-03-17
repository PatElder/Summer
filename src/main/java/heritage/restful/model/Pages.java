package heritage.restful.model;


import javax.persistence.*;

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
