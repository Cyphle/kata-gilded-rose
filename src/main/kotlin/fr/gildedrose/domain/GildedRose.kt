package fr.gildedrose.domain

class GildedRose(var items: Array<Item>) {
  fun updateQuality() {
    items.forEach { ItemUpdater(it).updateQuality(it) }
  }
}