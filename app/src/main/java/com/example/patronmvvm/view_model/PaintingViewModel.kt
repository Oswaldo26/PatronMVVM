package com.example.patronmvvm.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.patronmvvm.model.Painting
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PaintingViewModel: ViewModel() {
    private val _paintings = MutableStateFlow<List<Painting>>(emptyList())
    val paintings: MutableStateFlow<List<Painting>>
        get() = _paintings

    private val _selectedPainting = MutableStateFlow<Painting?>(null)
    val selectedPainting: MutableStateFlow<Painting?>
        get() = _selectedPainting

    init {
        loadPaintings()
    }

    private fun loadPaintings(){
        viewModelScope.launch {
            _paintings.value = listOf(
                Painting(1, "Starry Night", "Vincent van Gogh", "https://upload.wikimedia.org/wikipedia/commons/e/eb/Van_Gogh_-_Starry_Night_-_Google_Art_Project.jpg"),
                Painting(2, "Mona Lisa", "Leonardo da Vinci", "https://upload.wikimedia.org/wikipedia/commons/6/6a/Mona_Lisa.jpg")


            )
        }
    }

    fun selectPainting(painting: Painting){
        _selectedPainting.value = painting
    }

}