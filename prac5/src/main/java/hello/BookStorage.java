package hello;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookStorage {
    private static int i;
    ArrayList<Book> booksList;

    { // Блок инициализации
        booksList = new ArrayList<>();

        booksList.add(new Book(++i,"Коварство и любовь" ,"Шиллер Фридрих"));
        booksList.add(new Book(++i,"Хижина дяди Тома","Бичер-Стоу Гарриет"));
        booksList.add(new Book(++i,"Граф Монте-Кристо","Дюма Александр"));
        booksList.add(new Book(++i,"Сердце трех","Лондон Джек"));
    }

    public List<Book> index(){
        return booksList;
    }

    public Book show(int id){
        return booksList.stream().filter(book -> book.getId() == id).findAny().orElse(null);
    }

    public void save(Book book){
        book.setId(++i);
        booksList.add(book);
    }

    public void delete(int id) {
        booksList.removeIf(p -> p.getId() == id);
    }
}