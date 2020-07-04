import ru.geekbrains.ws.IProduct;
import ru.geekbrains.ws.ProductServiceWs;
import ru.geekbrains.ws.ProductsWSService;

public class HelloClient {
    private static ProductsWSService service = new ProductsWSService();
    public static void main(String[] args) {
        IProduct port = service.getProductsWSPort();
        for(ProductServiceWs pr: port.getProduct()){
            System.out.println(pr.getName());
        }
    }
}
