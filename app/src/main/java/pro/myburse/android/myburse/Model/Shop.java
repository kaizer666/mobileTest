package pro.myburse.android.myburse.Model;


import java.util.ArrayList;
import java.util.Date;

public class Shop {

    private long id;
    private Owner owner;
    private String title;
    private String text;
    private Date created_at;
    private Date updated_at;
    private String updated_at_formated;
    private String created_at_formated;
    private Image image;
    private String url;
    private double distance;
    private double latitude;
    private double longitude;
    private boolean is_mine;
    private boolean is_subscribed;
    private float rating;
    private int reviews_count;
    private ArrayList<Product> products;
    private ArrayList<Product> hot_products;



    public Shop(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdatedAt() {
        return updated_at;
    }

    public void setUpdatedAt(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getUpdatedAtFormated() {
        return updated_at_formated;
    }

    public void setUpdatedAtFormated(String updated_at_formated) {
        this.updated_at_formated = updated_at_formated;
    }

    public String getCreatedAtFormated() {
        return created_at_formated;
    }

    public void setCreatedAtFormated(String created_at_formatted) {
        this.created_at_formated = created_at_formatted;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public boolean isMine() {
        return is_mine;
    }

    public void isMine(boolean is_mine) {
        this.is_mine = is_mine;
    }

    public boolean isSubscribed() {
        return is_subscribed;
    }

    public void isSubscribed(boolean is_subscribed) {
        this.is_subscribed = is_subscribed;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getReviewsCount() {
        return reviews_count;
    }

    public void setReviewsCount(int reviews_count) {
        this.reviews_count = reviews_count;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getHotProducts() {
        return hot_products;
    }

    public void setHotProducts(ArrayList<Product> hot_products) {
        this.hot_products = hot_products;
    }
}
