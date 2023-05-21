package com.modulodecompras.modulo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Entity;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table()
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int valor;

//    @ManyToMany
//    @JoinTable(name = "pedido-produto",
//            joinColumns = @JoinColumn(name = "pedido_id"),
//            inverseJoinColumns = @JoinColumn(name = "produtos_id")
//    )
//    private List<Produtos> produtos;

    @ManyToMany
    @JoinTable(name = "pedido-produtos",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "produtos_id")
    )
    private List<Produtos> produtosped;


    @OneToMany(mappedBy = "pedido")
    private List<NotaFiscal> notaFiscal;


}

