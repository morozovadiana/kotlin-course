package ru.stimmax.ru.stimmax.lessons.lesson30.homework

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue


class InventoryManagerTest {
    private val inventoryManager = InventoryManager(10)

    @Test
    fun checkEmptyGetItem(){
        assertEquals(0, inventoryManager.getItemCount("apple"))
    }

    @Test
    fun checkExistGetItem() {
        inventoryManager.addItem("pearl", 2)
        assertEquals(2, inventoryManager.getItemCount("pearl"))
    }

    @Test
    fun checkMultipleGetItems() {
        inventoryManager.addItem("pearl", 2)
        inventoryManager.addItem("tomato", 2)
        assertEquals(2, inventoryManager.getItemCount("pearl"))
        assertEquals(2, inventoryManager.getItemCount("tomato"))
    }

    @Test
    fun throwErrorAddItem() {
        assertThrows (IllegalStateException::class.java) {
            inventoryManager.addItem("orange", 100)
        }
    }

    @Test
    fun checkAddItem() {
        inventoryManager.addItem("batat" , 4)
        assertEquals(4, inventoryManager.getItemCount("batat"))
    }

    @Test
    fun checkItemShoulBeRemovedFull() {
        inventoryManager.addItem("orange", 2)
        inventoryManager.removeItem("orange", 2)
        assertEquals(0, inventoryManager.getItemCount("orange"))
    }

    @Test
    fun checkItemShoulBeRemovedParticular() {
        inventoryManager.addItem("orange", 2)
        inventoryManager.removeItem("orange", 1)
        assertEquals(1, inventoryManager.getItemCount("orange"))
    }

    @Test
    fun checkRemoveItemTrue() {
        inventoryManager.addItem("orange", 2)
        assertTrue( inventoryManager.removeItem("orange", 2))
    }

    @Test
    fun checkDoesntRemoveUknownItem() {
        assertFalse( inventoryManager.removeItem("potato", 2))
    }

    @Test
    fun checkDoesntRemoveBigEmount() {
        inventoryManager.addItem("orange", 2)
        assertFalse ( inventoryManager.removeItem("orange", 20))
    }

    @Test
    fun checkRemoveNotFullQuantity() {
        inventoryManager.addItem("orange", 2)
        assertTrue ( inventoryManager.removeItem("orange", 1))
    }
}

