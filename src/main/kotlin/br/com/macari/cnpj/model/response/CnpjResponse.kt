package br.com.macari.cnpj.model.response

import com.fasterxml.jackson.annotation.JsonProperty

data class CnpjResponse (

    val status: String? = null,
    //@JsonProperty("ultima_atualizacao")
    val ultima_atualizacao: String? = null,
    val cnpj: String? = null,
    val tipo: String? = null,
    val porte: String? = null,
    val nome: String? = null,
    val fantasia: String? = null,
    val abertura: String? = null,
    val atividade_principal: List<Atividade>? = null,
    val atividades_secundarias: List<Atividade>? = null,
    val natureza_juridica: String? = null,
    val logradouro: String? = null,
    val numero: String? = null,
    val complemento: String? = null,
    val cep: String? = null,
    val bairro: String? = null,
    val municipio: String? = null,
    val uf: String? = null,
    val efr: String? = null,
    val situacao: String? = null,
    val data_situacao: String? = null,
    val motivo_situacao: String? = null,
    val situacao_especial: String? = null,
    val data_situacao_especial: String? = null,
    val capital_social: String? = null,
    val qsa: List<QuadroSocietario>? = null,
    val billing: Billing? = null
)
{
    override fun toString(): String {
        return "$cnpj;${atividade_principal?.first()?.code};${atividade_principal?.first()?.text};$cep;$municipio;$porte;$natureza_juridica;$uf"
    }
}

data class Atividade(
    var code: String? = null,
    var text: String? = null
)
data class QuadroSocietario(
    var nome: String? = null,
    var qual: String? = null,
    var pais_origem: String? = null,
    var nome_rep_legal: String? = null,
    var qual_rep_legal: String? = null,
)
data class Billing(
    val free: Boolean = false,
    val database: Boolean = false,
)
