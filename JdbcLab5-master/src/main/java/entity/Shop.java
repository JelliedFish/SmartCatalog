package entity;


import java.util.Objects;

public class Shop {

    private Long id;
    private String title;

    public Shop(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(id, shop.id) &&
                Objects.equals(title, shop.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
