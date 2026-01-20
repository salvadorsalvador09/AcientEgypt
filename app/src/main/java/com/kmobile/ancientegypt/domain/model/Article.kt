package com.kmobile.ancientegypt.domain.model

import androidx.annotation.DrawableRes

data class Article (
    val id: String,
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
    val urlImage: String?,
    val audioURL: String?,
    val videoURL: String?,
    val category: Category

)



// Buscar arte egipcio
//https://collectionapi.metmuseum.org/public/collection/v1/search?departmentId=10&hasImages=true&q=pharaoh
//
//// Obtener objeto específico
//https://collectionapi.metmuseum.org/public/collection/v1/objects/[objectID]
//
//// Listar todos los objetos egipcios
//https://collectionapi.metmuseum.org/public/collection/v1/objects?departmentIds=10
//```
//
//### 🎯 Datos que obtienes por artefacto:
//- **Información básica**: título, descripción, período, dinastía
//- **Imágenes**: primaryImage (alta resolución) + primaryImageSmall
//- **Clasificación**: cultura, reino (New Kingdom, Old Kingdom, etc.)
//- **Ubicación original**: subregion, locale (Tomb of X, Temple of Y)
//- **Fechas**: objectBeginDate, objectEndDate
//- **Tags**: palabras clave temáticas
//
//---
//
//## 📱 Propuesta de Estructura para tu App
//```
//AncientEgypt/
//├── data/
//│   ├── model/
//│   │   ├── MetObject.kt (modelo API del Met)
//│   │   ├── Article.kt
//│   │   ├── Category.kt
//│   │   └── MediaContent.kt
//│   │
//│   ├── remote/
//│   │   ├── MetApiService.kt (Retrofit)
//│   │   └── dto/ (Data Transfer Objects)
//│   │
//│   └── repository/
//│       └── MuseumRepository.kt
//│
//├── domain/
//│   └── usecase/
//│       ├── GetEgyptianArtifactsUseCase.kt
//│       └── SearchArtifactsUseCase.kt
//│
//├── ui/
//│   ├── theme/
//│   │   └── EgyptTheme.kt (colores dorado, azul egipcio)
//│   │
//│   └── screens/
//│       ├── HomeScreen.kt
//│       ├── CategoryScreen.kt
//│       ├── ArtifactDetailScreen.kt
//│       └── GalleryScreen.kt
//│
//└── ui_kit/
//├── components/
//│   ├── ArtifactCard.kt
//│   ├── ImageZoomable.kt (con gestos)
//│   ├── AudioPlayerCard.kt
//│   └── VideoPlayerCard.kt
//│
//└── gestures/ (reutilizar tus ejemplos)
//├── SwipeableGallery.kt
//├── ZoomableImage.kt
//└── DraggableMap.kt