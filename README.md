# s205348_Lykkehjulet
Made by Marcus Kastrup Ottosen for course 62550 User Experience and Mobile Application Devopment

**Læs venligst:**

Appen er lavet i compose frem for XML. Der bliver derfor brugt Lazy frem for RecyclerView. Mere præcist bruger jeg LazyVerticalGrid til bl.a. at vise kasserne med de gemte ord i. Denne Composable kræver @ExperimentalFoundationApi hvilket er grunden til, at dette er skrevet mange steder i koden.

Der bliver brugt navigation mellem fragmenterne vha. filen Navigation.kt som fungerer som min Navigation Component.
Der er 4 fragmenter: GameFragment, LoseGameFragment, WinGameFragment og WinGameFragment.

Arkitekturen er bygget op omkring MVVM.
