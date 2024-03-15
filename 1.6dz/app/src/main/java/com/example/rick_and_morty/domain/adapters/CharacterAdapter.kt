package com.example.rick_and_morty.domain.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.rick_and_morty.domain.models.Character
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.homework_2_6m.R
import com.example.homework_2_6m.databinding.ItemRickAndMortyBinding


class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    private var binding: ItemRickAndMortyBinding? = null

    inner class CharacterViewHolder(itemBinding: ItemRickAndMortyBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    private val differCallback = object : DiffUtil.ItemCallback<Character>() {
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        binding = ItemRickAndMortyBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CharacterViewHolder(requireNotNull(binding))
    }

    @SuppressLint("SetTextI18n", "LogNotTimber")
    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = differ.currentList[position]
        holder.itemView.apply {
            binding?.characterName?.text = character.name
            binding?.lastKnownLocation?.text = character.location?.name
            binding?.firstSeenIn?.text = character.origin?.name
            binding?.let {
                binding?.characterImage?.let { characterImage ->
                    characterImage.load(character.image) {
                        crossfade(true)
                        transformations(CircleCropTransformation())
                    }

                }
            }
            binding?.characterSpeciesAndStatus?.text =
                "${character.status} - ${character.species}"

            if (character.status?.contains("Dead") == true) {
                binding?.colorIndicator?.setImageResource(R.drawable.ic_circle_red)
            } else if (character.status?.contains("Alive") == true) {
                binding?.colorIndicator?.setImageResource(R.drawable.ic_circle_green)
            } else binding?.colorIndicator?.setImageResource(R.drawable.ic_circle_grey)

            setOnClickListener {
                onItemClickListener?.let { it(character) }
                Log.d("TAG", "${character.id}")
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    private var onItemClickListener: ((Character) -> Unit)? = null

    fun setOnItemClickListener(listener: (Character) -> Unit) {
        onItemClickListener = listener

    }

}