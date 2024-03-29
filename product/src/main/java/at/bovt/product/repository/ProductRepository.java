package at.bovt.product.repository;



import at.bovt.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepository extends MongoRepository<Product,String> {
}
