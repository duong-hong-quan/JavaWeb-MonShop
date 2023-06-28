/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.cart;

import quandh.products.ProductDTO;

import java.util.HashMap;
import java.util.Map;

/**
 * @author PC_HONGQUAN
 */
public class CartObj {

    private Map<String, Integer> items;
    private Map<String, ProductDTO> products;

    public static void main(String[] args) {
        CartObj cartObj = new CartObj();
        cartObj.addItemToCart("1", 1);
        cartObj.addItemToCart("1", 1);
        cartObj.addItemToCart("1", 1);
        cartObj.addItemToCart("1", 1);
        System.out.println(cartObj.getTotalItem()
        );
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public Map<String, ProductDTO> getProducts() {
        return products;
    }

    public boolean addProductToCart(String id, ProductDTO product) {
        boolean result = false;
        if (id == null) {
            return result;
        }
        if (id.trim().isEmpty()) {
            return result;
        }
        if (this.products == null) {
            this.products = new HashMap<>();
        }
        if (!this.products.containsKey(id)) {
            this.products.put(id, product);
        }
        return result;
    }

    public boolean addItemToCart(String id, int quantity) {
        boolean result = false;
        //1. Check data validation
        if (id == null) {
            return result;
        }
        if (id.trim().isEmpty()) {
            return result;
        }
        if (quantity <= 0) {
            return result;
        }
        //2. Check exsted items
        if (this.items == null) {
            this.items = new HashMap<>();
        }
        //3. drops item to items
        if (this.items.containsKey(id)) {
            int quan = items.get(id);
            quantity = quantity + quan;
        }
        items.put(id, quantity);
        result = true;
        return result;
    }

    public boolean removeItemFromCart(String id, int quantity) {
        boolean result = false;
        //1. Check data validation
        if (id == null) {
            return result;
        }
        if (id.trim().isEmpty()) {
            return result;
        }
        if (quantity <= 0) {
            return result;
        }
        //2. Check existed items
        if (this.items == null) {
            return result;
        }
        //3. Check existed items
        if (this.items.containsKey(id)) {
            //4. compare quantity
            int quan = this.items.get(id);
            if (quan < quantity) {
                return result;
            }
            quantity = quan - quantity;
            if (quantity == 0) {
                items.remove(id);
                if (this.items.isEmpty()) {
                    this.items = null;
                }
            } else {
                items.put(id, quantity);//update cart items
            }
            result = true;
        }//
        return result;

    }

    public void removeItemFromCart(String id) {
        if (items == null) {
            return;
        }
        if (items.containsKey(id)) {
            items.remove(id);
        }
        if (items.isEmpty()) {
            items = null;
        }
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        if (this.items != null) {
            for (Map.Entry<String, Integer> entry : this.items.entrySet()) {
                String id = entry.getKey();
                int quantity = entry.getValue();
                if (this.products != null && this.products.containsKey(id)) {
                    ProductDTO product = this.products.get(id);
                    totalPrice += quantity * product.getPrice();
                }
            }
        }
        return totalPrice;
    }

    public int getTotalItem() {
        int count = 0;
        if (this.items == null) {
            count = 0;
        } else {
            count = this.items.size();

        }
        return count;
    }

    public ProductDTO getProduct(String sku) {
        if (this.products.containsKey(sku)) {
            return this.products.get(sku);
        }
        return null;
    }
}
