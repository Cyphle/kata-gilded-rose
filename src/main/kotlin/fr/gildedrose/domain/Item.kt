package fr.gildedrose.domain

data class Item(var name: String, var sellIn: Int, var quality: Int) {
  fun decreaseQualityBy(value: Int) {
    var decreaseLevel = value
    while (decreaseLevel > 0) {
      if (quality > 0) {
        quality = quality - 1
      }
      --decreaseLevel
    }
  }

  fun increaseQualityBy(value: Int) {
    var increaseLevel = value
    while (increaseLevel > 0) {
      if (quality < 50) {
        quality = quality + 1
      }
      --increaseLevel
    }
  }
}