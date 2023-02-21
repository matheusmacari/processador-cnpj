package br.com.macari.cnpj.consts

const val C_INITIAL_DIR    = "c:/cnpjs"
const val C_PATH_BRASILAPI = "$C_INITIAL_DIR/brasilapi"
const val C_PATH_RECEITAWS = "$C_INITIAL_DIR/receitaws"
const val C_PATH_RESPONSE_BRASILAPI = "$C_PATH_BRASILAPI/responses/"
const val C_PATH_RESPONSE_RECEITAWS = "$C_PATH_RECEITAWS/responses/"
const val C_LIST_FILE     = "lista.txt"
const val C_FILE_NAME_CSV = "lista.csv"
const val C_COLUNAS_CSV   = "cnpj;atividade_codigo;atividade_descricao;cep;municipio;porte;natureza;uf;telefone;telefone2"

enum class ServiceApi {
    BRASILAPI, RECEITAWS
}
