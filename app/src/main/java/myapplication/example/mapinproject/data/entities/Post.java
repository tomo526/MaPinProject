package myapplication.example.mapinproject.data.entities;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Post {
    private Number assessment;
    private String category;
    private String content;
    private String image;
    private String username;
    private String postname;
    private Number latitube;
    private Number longitube;

    public Post(){

    }

    public  Post(String _category,String _content,String _postname){
        this.category = _category;
        this.content = _content;
        this.postname = _postname;
    }


    public Post(Number _assessment, String _category, String _content, String _image, String _username, String _postname, Number _laittube, Number _longitube) {
        this.assessment = _assessment;
        this.category = _category;
        this.content = _content;
        this.image = _image;
        this.username = _username;
        this.postname = _postname;
        this.latitube = _laittube;
        this.longitube = _longitube;
    }

    @Override
    public String toString() {
        return "Post{" +
                "assessment=" + assessment +
                ", category='" + category + '\'' +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", username='" + username + '\'' +
                ", postname='" + postname + '\'' +
                ", latitube=" + latitube +
                ", longitube=" + longitube +
                '}';
    }

    public Number getAssessment() { return assessment; }

    public String getCategory() { return category; }

    public String getContent() { return content; }

    public String getImage() { return image; }

    public String getUsername() { return username; }

    public String getPostname() { return postname; }

    public Number getLatitube() { return latitube; }

    public Number getLongitube() { return longitube; }
}