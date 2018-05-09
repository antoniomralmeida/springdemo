package br.com.opencare.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.opencare.springdemo.model.Product;

public interface ProdutoRepository extends JpaRepository<Product, Long>{

}
