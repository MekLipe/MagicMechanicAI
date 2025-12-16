package dev.java10x.MagicMechanicAI.model;

public enum TipoQualidade {
    // Opção idêntica à peça que vem no carro 0km, mas vendida pela montadora
    GENUINA,

    // Peça vendida pelo mesmo fabricante que fornece à montadora (ex: Bosch)
    ORIGINAL_REPOSICAO,

    // Peças de fabricantes independentes, mas de alto padrão (ex: DEPO)
    PARALELA_PREMIUM,

    // Peças genéricas, mais baratas
    PARALELA_GENERICA,

    // Peças feitas para melhorar a performance do carro
    PERFORMANCE
}
