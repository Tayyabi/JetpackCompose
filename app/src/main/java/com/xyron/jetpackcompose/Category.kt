package com.xyron.jetpackcompose

import java.util.UUID

data class Category(val id: UUID = UUID.randomUUID(), val categoryName: String, val categoryImage:String)