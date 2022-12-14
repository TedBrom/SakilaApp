package com.sakilla.api.SakilaApp;
import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "category")
public class Category
{
    //Attributes
    //define the PK
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int categoryId;

    @Column(name = "name")
    String catName;

    //Constructors

    public Category(int categoryId, String catName)
    {
        this.categoryId = categoryId;
        this.catName = catName;
    }
    public Category(){}

    //methods

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return categoryId == category.categoryId && Objects.equals(catName, category.catName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, catName);
    }
}
