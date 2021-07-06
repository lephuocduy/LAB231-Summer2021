/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duylp.dtos;

import java.util.HashMap;

/**
 *
 * @author Le Phuoc Duy
 */
public class ListRequestDTO {
    
    private String name;
    private HashMap<String, ProductDTO> list;

    public void addList(ProductDTO dto) throws Exception {
        if (this.list.containsKey(dto.getProductID())) {
            int quantity = this.list.get(dto.getProductID()).getQuantityRequest() + 1;
            dto.setQuantityRequest(quantity);
        }
        this.list.put(dto.getProductID(), dto);
    }

    public ListRequestDTO() {
        this.name = "GUEST";
        this.list = new HashMap<>();
    }

    public ListRequestDTO(String name) {
        this.name = name;
        this.list = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, ProductDTO> getList() {
        return list;
    }

    public void remove(String id) throws Exception {
        if (this.list.containsKey(id)) {
            this.list.remove(id);
        }
    }

    public void updateList(String id, int newQuantity) throws Exception {
        if (this.list.containsKey(id)) {
            this.list.get(id).setQuantityRequest(newQuantity);
        }
    }
    
}
