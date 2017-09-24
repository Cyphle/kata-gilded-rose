package fr.gildedrose.domain

class GildedRose(var items: Array<Item>) {
  fun updateQuality() {
    items.indices.forEach { i ->
      updateQuality(i)
    }
  }

  private fun updateQuality(i: Int) {
    if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
      return
    }

    if (items[i].name.equals("Aged Brie")) {
      if (items[i].quality < 50) {
        items[i].quality = items[i].quality + 1
      }
    } else if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
      if (items[i].quality < 50) {
        items[i].quality = items[i].quality + 1

        if (items[i].sellIn < 11) {
          if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1
          }
        }

        if (items[i].sellIn < 6) {
          if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1
          }
        }
      }
    } else {
      if (items[i].quality > 0) {
        items[i].quality = items[i].quality - 1
      }
    }

    items[i].sellIn = items[i].sellIn - 1

    if (items[i].sellIn < 0) {
      if (items[i].name.equals("Aged Brie")) {
        if (items[i].quality < 50) {
          items[i].quality = items[i].quality + 1
        }
      } else {
        if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
          items[i].quality = items[i].quality - items[i].quality
        } else {
          if (items[i].quality > 0) {
            items[i].quality = items[i].quality - 1
          }
        }
      }
    }
  }

}