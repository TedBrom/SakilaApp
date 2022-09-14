package com.sakilla.api.SakilaApp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestingCategory {


    SakilaAppApplication sakilaAppApplication;

    @Mock
    CategoryRepository categoryRepository;
    @Mock
    FilmRepository filmRepository;
    @Mock
    ActorRepository actorRepository;


    @BeforeEach
    void setup()
    {
        sakilaAppApplication = new SakilaAppApplication(actorRepository, filmRepository, categoryRepository);
    }


    @Test
    void getAllCat()
    {

        List<Category> categoryList = new ArrayList<>();

        Category testCat = new Category(1,"spooky");
        Category testCat2 = new Category(2, "funny");

        categoryList.add(testCat);
        categoryList.add(testCat2);

        Iterable <Category> categoryIterable = categoryList;

        when(categoryRepository.findAll()).thenReturn(categoryIterable);

        Iterable <Category> Expected = categoryIterable;
        Iterable <Category> Actual = sakilaAppApplication.getAllCategory();

        Assertions.assertEquals(Expected, Actual, "Get all categories broke :(");

    }

    @Test
    void testGetACategory(){
        when(categoryRepository.findById(1)).thenReturn(Optional.of(new Category()));
        Category output = categoryRepository.findById(1).get();
        Category expected = new Category();
        Assertions.assertEquals(expected, output, "why nay");

    }

    @Test
    void editCatName(){
        Category category = new Category();
        Assertions.assertEquals(null, category.catName);
        when(categoryRepository.findById(1)).thenReturn(Optional.of(category));
        Category newCat = new Category();
        newCat.setCatName("newCatName");
        ArgumentCaptor<Category> captor = ArgumentCaptor.forClass(Category.class);
        sakilaAppApplication.editCategory(1, newCat);
        verify(categoryRepository).save(newCat);
    }

}
