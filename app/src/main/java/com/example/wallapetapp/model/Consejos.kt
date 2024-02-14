package com.example.wallapetapp.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.wallapetapp.R

data class Consejo(var titulo: String, var descripcion: String, var webReferencia: String)


@Composable
fun getConsejos(): List<Consejo> {

    return listOf(
        Consejo(
            stringResource(R.string.fuegos_artificiales),
            stringResource(R.string.no_dejar_a_la_mascota_sola_en_casa) +"\n"+ stringResource(R.string.mantener_la_calma_y_tratar_de_transmit_rsela) +"\n"+ stringResource(
                R.string.generar_otro_tipo_de_ruidos_para_tapar_el_sonido_de_los_petardos
            ) +"\n"+ stringResource(R.string.medicamentos_naturales_que_dismunuyen_el_estr_s) +"\n"+ stringResource(
                R.string.ropa_tranquilizadora
            ) +"\n"+ stringResource(R.string.distraerla_con_premios) +"\n"+ stringResource(R.string.contactar_con_educadores_caninos),
            "https://www.srperro.com/consejos/salud-perruna/consejos-para-calmar-a-los-perros-en-epoca-de-petardos"
        ),
        Consejo(
            stringResource(R.string.contacto_con_la_procesionaria),
            stringResource(R.string.sacar_la_mascota_de_la_zona_donde_haya_las_orugas) +"\n"+ stringResource(
                R.string.abrirle_la_boca_para_observar_el_estado_de_la_lengua
            ) +"\n"+ stringResource(R.string.lavar_la_zona_con_suero_fisiol_gico_o_agua_evitando_que_se_la_trague) +"\n"+ stringResource(
                R.string.no_frotar_la_zona_afextada
            ) +"\n"+ stringResource(R.string.acudir_al_veterinario),
            "https://www.srperro.com/consejos/salud-perruna/que-hacer-si-tu-perro-entra-en-contacto-con-la-oruga-procesionaria/"

        ),
        Consejo(
            stringResource(R.string.alimentos_a_evitar),
            stringResource(R.string.el_chocolate_cuanto_m_s_negro_sea_el_chocolate_m_s_toxicidad) +"\n"+ stringResource(
                R.string.cebolla_y_ajo
            ) +"\n"+ stringResource(R.string.cualquier_alimento_con_cafe_na) +"\n"+ stringResource(R.string.uvas_y_uvas_pasas) +"\n"+ stringResource(
                R.string.nueces_de_pec_n
            ) +"\n"+ stringResource(R.string.cualquier_alimento_con_xilitol) +"\n"+ stringResource(R.string.huesos_y_pepitas_de_fruta) +"\n"+ stringResource(
                R.string.aguacate
            ) +"\n"+ stringResource(R.string.bebidas_que_contengan_alcohol) +"\n"+ stringResource(R.string.l_cteos),
            "https://www.srperro.com/consejos/nutricion/que-alimentos-son-peligrosos-o-venenosos-para-los-perros/"

        ),
        Consejo(
            stringResource(R.string.en_la_nieve),
            stringResource(R.string.ten_a_tu_mascota_siempre_a_la_vista) +"\n"+ stringResource(R.string.procura_que_siempre_lleve_alg_n_tipo_de_identificaci_n) +"\n"+ stringResource(
                R.string.usa_protector_de_piel_en_las_zonas_m_s_expuestas_al_sol
            ) +"\n"+ stringResource(R.string.lleva_una_toalla_para_limpiarle_las_patas_de_vez_en_cuando) +"\n"+ stringResource(
                R.string.evita_que_coma_nieve
            ),
            "https://www.srperro.com/consejos/salud-perruna/nieve-frio-y-perros-algunos-consejos-basicos-para-los-paseos-de-invierno/"

        ),
        Consejo(
            stringResource(R.string.en_la_playa),
            stringResource(R.string.nunca_tires_a_tu_mascota_al_agua_si_no_quiere_meterse) +"\n"+ stringResource(
                R.string.tener_alg_n_sitio_con_sombra_para_que_pueda_refugiarse_del_calor_excesivo
            ) +"\n"+ stringResource(R.string.intentar_evitar_que_beba_agua_salada) +"\n"+ stringResource(
                R.string.vigilar_con_las_corrientes
            ) +"\n"+ stringResource(R.string.llevar_siempre_agua_dulce_y_hacer_que_beban_con_frecuencia),
            "https://www.srperro.com/consejos/salud-perruna/chapuzones-perrunos-sin-sustos-consejos-para-un-buen-dia-de-playa-o-piscina/"

        ),

        )
}



