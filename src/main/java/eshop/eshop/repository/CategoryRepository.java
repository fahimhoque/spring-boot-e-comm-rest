package eshop.eshop.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import eshop.eshop.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
