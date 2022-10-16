package rest.item.model;

public class Review {

    private int itemId;
    private int userId;
    private int rate;
    private String comment;

    public Review(int userId, int productId, int rate, String comment) {
        this.userId = userId;
        this.itemId = productId;
        this.rate = rate;
        this.comment = comment;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
