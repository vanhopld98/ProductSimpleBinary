import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        int choice;
        do {
            menu();
            choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    productManager.showAll();
                    break;
                }
                case 2: {
                    inputProduct(productManager);
                    break;
                }
                case 3: {
                    findProductById(productManager);
                    break;
                }
            }
        } while (choice != 0);
        writeToText(productManager.getProducts());
    }


    public static void writeToText(ArrayList<Product> products) {
        try {
            OutputStream os = new FileOutputStream("student.txt");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(products);
            oos.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void inputProduct(ProductManager productManager) {
        System.out.println("Nhập id sản phẩm");
        sc.nextLine();
        String id = sc.nextLine();
        System.out.println("Nhập tên sản phẩm");
        String name = sc.nextLine();
        System.out.println("Nhập hãng sản xuất");
        String manufacturer = sc.nextLine();
        System.out.println("Nhập giá tiền");
        int price = sc.nextInt();
        System.out.println("Nhập mô tả");
        sc.nextLine();
        String note = sc.nextLine();
        Product product = new Product(id, name, manufacturer, price, note);
        productManager.addProduct(product);
    }

    private static void findProductById(ProductManager productManager) {
        System.out.println("Nhập id cần tìm");
        sc.nextLine();
        String id = sc.nextLine();
        int index = productManager.findProductById(id);
        if (index != -1) {
            System.out.println(productManager.getProducts().get(index));
        } else {
            System.out.println("Không tìm thấy id này");
        }
    }

    private static void menu() {
        System.out.println("MENU");
        System.out.println("1. Hiển thị sản phẩm");
        System.out.println("2. Thêm sản phẩm");
        System.out.println("3. Tìm kiếm thông tin sản phẩm");
        System.out.println("0. Exit");
        System.out.println("Nhập lựa chọn của bạn:");
    }
}