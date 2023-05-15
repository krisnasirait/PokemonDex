package com.krisna.pokemondex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.krisna.pokemondex.model.Pokemon
import com.krisna.pokemondex.model.PokemonData
import com.krisna.pokemondex.ui.theme.PokemonDexTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonDexTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PokemonList(pokemons = PokemonData.pokemons, onPokemonClick = {
                        // TODO: Implement this to navigate to the Pokemon details page
                    })
                }
            }
        }
    }
}

@Composable
fun PokemonList(pokemons: List<Pokemon>, onPokemonClick: (Pokemon) -> Unit) {
    LazyColumn {
        items(pokemons.size) { index ->
            val pokemon = pokemons[index]
            PokemonListItem(pokemon = pokemon, onClick = { onPokemonClick(pokemon) })
        }
    }
}

@Composable
fun PokemonListItem(pokemon: Pokemon, onClick: () -> Unit) {
    Row(modifier = Modifier.clickable(onClick = onClick)) {
        Image(painter = painterResource(pokemon.image), contentDescription = pokemon.name)
        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(text = pokemon.name)
            Text(text = pokemon.id)
        }
    }
}

