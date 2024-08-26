package com.daitiks.client.response;

import com.daitiks.model.Cartas;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartaDtoApi implements Serializable {
    private List<Cartas> cards;

    public List<Cartas> getCards() {
        return cards;
    }


}
