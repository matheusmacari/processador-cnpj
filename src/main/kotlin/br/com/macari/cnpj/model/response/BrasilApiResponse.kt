package br.com.macari.cnpj.model.response

import java.math.BigInteger

data class BrasilApiResponse (

    val cnpj : String? = null,
    val identificador_matriz_filial: String? = null,
    val descricao_matriz_filial: String? = null,
    val razao_social: String? = null,
    val nome_fantasia: String? = null,
    val situacao_cadastral : String? = null,
    val descricao_situacao_cadastral: String? = null,
    val data_situacao_cadastral: String? = null,
    val motivo_situacao_cadastral: String? = null,
    val nome_cidade_exterior: String? = null,
    val codigo_natureza_juridica: String? = null,
    val data_inicio_atividade: String? = null,
    val cnae_fiscal: String? = null,
    val cnae_fiscal_descricao: String? = null,
    val descricao_tipo_logradouro: String? = null,
    val logradouro: String? = null,
    val numero: String? = null,
    val complemento: String? = null,
    val bairro: String? = null,
    val cep: String? = null,
    val uf: String? = null,
    val codigo_municipio: String? = null,
    val municipio: String? = null,
    val ddd_telefone_1: String? = null,
    val ddd_telefone_2: String? = null,
    val ddd_fax: String? = null,
    val qualificacao_do_responsavel: String? = null,
    val capital_social: Double? = null,
    val porte: String? = null,
    val descricao_porte: String? = null,
    val opcao_pelo_simples: Boolean? = null,
    val data_opcao_pelo_simples: String? = null,
    val data_exclusao_do_simples: String? = null,
    val opcao_pelo_mei: Boolean = false,
    val natureza_juridica: String? = null,
    val situacao_especial: String? = null,
    val data_situacao_especial: String? = null,
    val cnaes_secundarios : List<Cnaes>? = null,
    val qsa : List<QSA>? = null,
)
{
    override fun toString(): String {
        return  "$cnpj;${cnae_fiscal_descricao};${cnaes_secundarios?.first()?.descricao};$cep;$municipio;$porte;$natureza_juridica;$uf;$ddd_telefone_1;$ddd_telefone_2"
    }
}

data class Cnaes(
    var codigo: String? = null,
    var descricao: String? = null
)
data class QSA(
    var identificador_de_socio: String? = null,
    var nome_socio: String? = null,
    var cnpj_cpf_do_socio: String? = null,
    var codigo_qualificacao_socio: String? = null,
    var percentual_capital_social: String? = null,
    var data_entrada_sociedade: String? = null,
    var cpf_representante_legal: String? = null,
    var nome_representante_legal: String? = null,
    var codigo_qualificacao_representante_legal: String? = null,
)
