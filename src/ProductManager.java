import java.util.ArrayList;

public class ProductManager {
    private ArrayList<Product> productArrayList=new ArrayList<>();

    public ArrayList<Product> getProducts() {
        return productArrayList;
    }

    public void setProducts(ArrayList<Product> products) {
        this.productArrayList = products;
    }

    public void showAll() {
        for (Product product : productArrayList) {
            System.out.println(product);
        }
    }

    public void addProduct(Product product) {
        productArrayList.add(product);
    }

    public int findProductById(String id) {
        int index = -1;
        for (int i = 0; i < productArrayList.size(); i++) {
            if (productArrayList.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }
}