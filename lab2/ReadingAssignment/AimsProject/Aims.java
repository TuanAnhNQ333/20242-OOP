public class Aims {
    public static void main(String[] args) {
        // Create a new cart
        Cart anOrder = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation",18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        // In danh sách các DVD trong giỏ hàng
        anOrder.printCart();

        // Xóa một DVD khỏi giỏ hàng
        anOrder.removeDigitalVideoDisc(dvd2);

        // Hiển thị giỏ hàng sau khi xóa
        System.out.println("\nCart after removing:");
        anOrder.printCart();
    }

}

/*  Question: Is JAVA a Pass by Value or a Pass by Reference programming language?
(Java là ngôn ngữ truyền theo giá trị hay truyền theo tham chiếu)
 Lý do : 
Java là ngôn ngữ lập trình "pass by value", nên nó là truyền giá trị.
*/
