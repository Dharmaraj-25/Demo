package in.dotworld.app1;

public class Mail {
    private String header,subject;
    int image;

    public Mail(String header, String subject, int image) {
        this.header = header;
        this.subject = subject;
        this.image = image;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
