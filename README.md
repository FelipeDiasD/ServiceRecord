# Service Record app

Uma aplicação para registrar serviços de TI


## Table of contents

- [Visão geral](#overview)
    - [A applicação](#the-application)
    - [Screenshot](#screenshot)
    - [Links](#links)
- [Meu desenvolvimento](#my-process)
    - [Ferramentas utilizadas](#built-with)
    - [O que aprendi](#what-i-learned)
    - [Próximos passos](#continued-development)
    - [Recursos úteis](#useful-resources)
- [Autor](#author)


## Overview
Essa aplicação foi construída com o simples propósito de registrar os serviços realizados
por um departamento ou técnico de TI, visando facilitar o histórico de seus clientes.



### The application
Uma aplicação web desenvolvida utilizando Java e o framework Springboot.




### Screenshot
TODO
### Links


- URL do deploy: [Em breve](https://your-live-site-url.com)

## My process

### Built with

- Java 17
- Spring boot 3 framework
- Lombok library



### What I learned

Nesse projeto acompanhei a 

```java
  
@DeleteMapping("/customers/{id}")
public void findAllCustomers(@PathVariable Integer id){
        try{
        customerRepository.deleteById(id);
        }
        catch (Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }

}
```


### Continued development



### Useful resources

## Author

- Website(GitHub) - [Felipe Dias](https://www.your-site.com)
- LinkedIn - [Felipe Dias](https://www.linkedin.com/in/felipe-dsprado/)

