package net.ttcxy.tangtang.security.properties;

public class ValidateCodeProperties {

    private ImageCodeProperties image = new ImageCodeProperties();

    private MailCodeProperties mail = new MailCodeProperties();

    public MailCodeProperties getMail() {
        return mail;
    }

    public void setMail(MailCodeProperties mail) {
        this.mail = mail;
    }

    public ImageCodeProperties getImage() {
        return image;
    }

    public void setImage(ImageCodeProperties image) {
        this.image = image;
    }
}
