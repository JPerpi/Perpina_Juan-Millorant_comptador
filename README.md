# Activitat 1: Millorant el comptador
## 1. Anàlisi de l’estructura del projecte

  El projecte consisteix en un comptador de clics, usa com a llenguatge de programació Kotlin.
  
  La seua estructura aquesta formada per tres carpetes principals que són: 
    -La carpeta manifest, que conté el AndroidManifest.xml
    -la carpeta java que conté l'app i els test 
    -La carpeta res on es troben els recursos que usarà l'aplicació

  #### “Si volguera afegir una nova activitat, sería suficient crear el fitxer de layout i el fitxer Kotlin amb la classe?”
  
  A part de crear els fitxer *layout i el fitxer amb la classe s'hauria de modificar el *AndroidManifest.*xml
  perquè si no l'aplicació no detectaria que has creat una nova activitat.

## 2. Análisi del clicle de vida i el problema de la pèrdua d’estat

El comptador es reinicia al girar la pantalla pel fet que android al girar la pantalla no guarda l'estat de l'app,
a més no s'ha aplicat un control per a evitar que això succeïsca.
Per a evitar-ho introduirem aquest codi perquè guarde l'estat de l'app abans de girar-lo

      'override fun onSaveInstanceState(estat: Bundle) {
        super.onSaveInstanceState(estat)
        // Codi per a guardar l'estat
        estat.putInt("Comptador", comptador)
        val textViewContador=findViewById<TextView>(R.id.textViewComptador)
        textViewContador.setText(comptador.toString())
    }'

I aquest per a restaurar l'estat guardat

      'override fun onRestoreInstanceState(estat: Bundle) {
        super.onRestoreInstanceState(estat)
        // Codi per a guardar l'estat
        comptador=estat.getInt("Comptador")
        val textViewContador=findViewById<TextView>(R.id.textViewComptador)
        textViewContador.setText(comptador.toString())
    }'



## Solució a la pèrdua d’estat
## Ampliant la funcionalitat amb decrements i Reset
## Canvis per implementar el View Binding
