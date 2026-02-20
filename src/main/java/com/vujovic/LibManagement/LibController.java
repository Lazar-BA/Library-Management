package com.vujovic.LibManagement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("api/books")
public class LibController {

    @GetMapping
    public List<Library> getBooks() {

        try {
            return List.of(
                    new Library(
                            "1984",
                            "George Orwell",
                            1949,
                            "8275394678"
                    ),
                    new Library(
                            "Animal Farm",
                            "George Orwell",
                            1945,
                            "080442957X"
                    )//"817450494X"
            );
        } catch (InvalidTitle e) {
            throw new RuntimeException(e);
        } catch (InvalidAuthor e) {
            throw new RuntimeException(e);
        } catch (InvalidYear e) {
            throw new RuntimeException(e);
        } catch (InvalidISBN e) {
            throw new RuntimeException(e);
        }
    }
}
