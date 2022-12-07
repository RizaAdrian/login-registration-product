package com.project.login.repo;

import com.project.login.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author RizaAdrian
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

	Optional<Product> findByProductId(Long id);
	Optional<Product> findById(Long id);

}
