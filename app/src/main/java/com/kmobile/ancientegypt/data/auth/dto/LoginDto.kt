package com.kmobile.ancientegypt.data.auth.dto
import com.fasterxml.jackson.annotation.JsonProperty


data class LoginRequestDto(
    @JsonProperty("Email")
    val email: String,
    @JsonProperty("Password")
    val password: String
)


data class LoginResponseDto(
    val data: Data,
    val message: String,
)

data class Data(
    @JsonProperty("Cliente")
    val cliente: String,
    @JsonProperty("UUID")
    val uuid: String,
    @JsonProperty("Estatus")
    val estatus: String,
    @JsonProperty("Email")
    val email: String,
    @JsonProperty("Password")
    val password: String,
    @JsonProperty("RazonSocial")
    val razonSocial: String,
    @JsonProperty("RFC")
    val rfc: String,
    @JsonProperty("UsoCFDI")
    val usoCfdi: String,
    @JsonProperty("FiscalRegimen")
    val fiscalRegimen: String,
    @JsonProperty("Regimen")
    val regimen: String,
    @JsonProperty("CFDICodigoPostal")
    val cfdicodigoPostal: String,
    @JsonProperty("Nombre")
    val nombre: String,
    @JsonProperty("ApellidoPaterno")
    val apellidoPaterno: String,
    @JsonProperty("ApellidoMaterno")
    val apellidoMaterno: String,
    @JsonProperty("NombreCompleto")
    val nombreCompleto: String,
    @JsonProperty("ConektaID")
    val conektaId: String,
    @JsonProperty("Confirmado")
    val confirmado: Boolean,
    @JsonProperty("FechaConfirmacion")
    val fechaConfirmacion: String,
    @JsonProperty("Terminos")
    val terminos: Boolean,
    @JsonProperty("FechaTerminos")
    val fechaTerminos: String,
    @JsonProperty("Privacidad")
    val privacidad: Boolean,
    @JsonProperty("FechaPrivacidad")
    val fechaPrivacidad: String,
    @JsonProperty("CodigoPostal")
    val codigoPostal: Any?,
    @JsonProperty("Celular")
    val celular: String,
    @JsonProperty("Telefonos")
    val telefonos: String,
    @JsonProperty("Extension")
    val extension: String,
    @JsonProperty("FechaNacimiento")
    val fechaNacimiento: Any?,
    @JsonProperty("Genero")
    val genero: String,
    @JsonProperty("PermissionBase")
    val permissionBase: Boolean,
    @JsonProperty("PermissionBaseMedio")
    val permissionBaseMedio: Any?,
    @JsonProperty("CodigoCelular")
    val codigoCelular: String,
    @JsonProperty("ExpiracionCodigo")
    val expiracionCodigo: String,
    @JsonProperty("Imagen")
    val imagen: String,
    @JsonProperty("GUID")
    val guid: String,
    @JsonProperty("CloseSession")
    val closeSession: Boolean,
    @JsonProperty("PerfilLealtad")
    val perfilLealtad: PerfilLealtad,
    @JsonProperty("TipoNotificacion")
    val tipoNotificacion: List<TipoNotificacion>,
    @JsonProperty("CategoriaNotificacion")
    val categoriaNotificacion: List<CategoriaNotificacion>,
    @JsonProperty("CuponesLealtad")
    val cuponesLealtad: List<CuponesLealtad>,
    @JsonProperty("Saldo")
    val saldo: Any?,
    @JsonProperty("HabilitaMetodosPago")
    val habilitaMetodosPago: Boolean,
    @JsonProperty("FormaPago")
    val formaPago: Long,
)

data class PerfilLealtad(
    @JsonProperty("Cliente")
    val cliente: String,
    @JsonProperty("clv_nivelxcliente")
    val clvNivelxcliente: Long,
    @JsonProperty("clv_nivel")
    val clvNivel: Long,
    @JsonProperty("Nivel")
    val nivel: String,
    @JsonProperty("ComprasMes")
    val comprasMes: Long,
    @JsonProperty("SiguienteNivel")
    val siguienteNivel: String,
    @JsonProperty("MontoSiguienteNivel")
    val montoSiguienteNivel: Double,
    @JsonProperty("Factor")
    val factor: Double,
    @JsonProperty("MontoMinimo")
    val montoMinimo: Double,
    @JsonProperty("MontoMaximo")
    val montoMaximo: Double,
    @JsonProperty("Beneficios")
    val beneficios: String,
    @JsonProperty("BeneficiosSiguienteNivel")
    val beneficiosSiguienteNivel: String,
    @JsonProperty("ColorInicial")
    val colorInicial: String,
    @JsonProperty("ColorFinal")
    val colorFinal: String,
    @JsonProperty("Puntos")
    val puntos: Double,
    @JsonProperty("Icon3x")
    val icon3x: String,
    @JsonProperty("Icon2x")
    val icon2x: String,
    @JsonProperty("Icon")
    val icon: String,
    @JsonProperty("Categoria")
    val categoria: Categoria,
)

data class Categoria(
    @JsonProperty("clv_categoria")
    val clvCategoria: Long,
    @JsonProperty("Descripcion")
    val descripcion: Any?,
    @JsonProperty("Image")
    val image: String,
    @JsonProperty("Image2x")
    val image2x: String,
    @JsonProperty("Image3x")
    val image3x: String,
    @JsonProperty("Icon")
    val icon: String,
    @JsonProperty("MostrarTodo")
    val mostrarTodo: Boolean,
)

data class TipoNotificacion(
    @JsonProperty("clv_tiponotificacion")
    val clvTiponotificacion: Long,
    @JsonProperty("TipoNotificacion")
    val tipoNotificacion: String,
    @JsonProperty("Activo")
    val activo: Boolean,
)

data class CategoriaNotificacion(
    @JsonProperty("clv_categorianotificacion")
    val clvCategorianotificacion: Long,
    @JsonProperty("Categoria")
    val categoria: String,
    @JsonProperty("Activo")
    val activo: Boolean,
)

data class CuponesLealtad(
    @JsonProperty("clv_cupon")
    val clvCupon: Long,
    @JsonProperty("Codigo")
    val codigo: String,
    @JsonProperty("Porcentaje")
    val porcentaje: Any?,
    @JsonProperty("Descripcion")
    val descripcion: Any?,
    @JsonProperty("ImagenLealtad")
    val imagenLealtad: String,
    @JsonProperty("Cantidad")
    val cantidad: Double,
    @JsonProperty("Aplica")
    val aplica: String,
    @JsonProperty("LeyendaCheckOut")
    val leyendaCheckOut: String,
    @JsonProperty("Articulos")
    val articulos: Any?,
)
