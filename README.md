# Service Record app

Uma aplicação para registrar serviços de TI


## Table of contents

- [Visão geral](#visão-geral)
    - [A applicação](#a-aplicação)
    - [Screenshot](#screenshot)
    - [Links](#links)
- [Meu desenvolvimento](#meu-desenvolvimento)
    - [Ferramentas utilizadas](#built-with)
    - [O que aprendi](#o-que-aprendi)
    - [Próximos passos](#próximos-passos)
    - [Recursos úteis](#recursos-úteis)
- [Autor](#autor)


## Visão geral
Essa aplicação foi construída com o simples propósito de registrar os serviços realizados
por um departamento ou técnico de TI, visando facilitar o histórico de seus clientes.



### A aplicação
Uma aplicação web desenvolvida utilizando Java e o framework Springboot.

#### Diagrama preliminar 
![ServiceRecordDiagram](/src/main/resources/assets/ServiceRecordDiagram.drawio.png)


### Screenshot
TODO
### Links


- URL do deploy: [Em breve](https://your-live-site-url.com)

## Meu desenvolvimento
  
### Built with

- Java 17
- Spring boot 3
- Lombok



### O que aprendi

Durante o desenvolvimento, utilizei na maioria conhecimentos que já tinha algum domínio
porém, sempre há algo para se aprender.

No caso, quando temos uma relação JPA na aplicação, na qual nas duas entidades eu tenho
campos declarados apontando uma para a outra, isso pode ocasionar um loop quando eu tiver
que criar ou atualizar uma dessas entidades. Neste caso, utilizamos a notação @JsonManagedReference
para referenciar a entidade "pai" que tem o campo da entidade "filha" relacionado. Já na entidade "filha"
utilizamos a notação @JsonBackReference no campo que referencia a entidade "pai"



#### Entidade "pai"
```java
@Entity
@Table(name = "tb_customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @NonNull
    private String name;

    @NonNull
    private String email;
//CAMPO QUE REFERENCIA ENTIDADE FILHA
    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @JsonManagedReference
    @NonNull
    @OneToMany(cascade = CascadeType.ALL)
    private List<JobRecord> jobs;

}
```
#### Entidade "filha"
```java
@Entity
@Table(name = "tb_address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id")
    private Long id;
    //CAMPO QUE REFERENCIA ENTIDADE PAI
    @JsonBackReference
    @OneToOne(mappedBy = "address")
    private Customer customer;
    
    private String street;
    private String city;
    private String state;
    private String cep;
    private String country;


}
```
### Próximos passos



### Recursos úteis

## Autor

- Website(GitHub) - [Felipe Dias](https://www.your-site.com)
- LinkedIn - [Felipe Dias](https://www.linkedin.com/in/felipe-dsprado/)

