package ir.reza_mahmoudi.githubusers.core.util.view

import android.view.View

fun View.show(){
    this.visibility = View.VISIBLE
}
fun View.hide(){
    this.visibility = View.INVISIBLE
}
fun View.gone(){
    this.visibility = View.GONE
}