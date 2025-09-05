package com.example.easy_finance_tracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.example.easy_finance_tracker.databinding.FragmentListBinding
import kotlin.getValue

class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val args: ListFragmentArgs by navArgs()
    private val vm: ExpensesViewModel by activityViewModels()

    private lateinit var categoryAdapter: CategoryChipAdapter
    private lateinit var expensesAdapter: ExpensesAdapter

    override fun onCreateView(i: LayoutInflater, c: ViewGroup?, s: Bundle?): View {
        _binding = FragmentListBinding.inflate(i, c, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // adapters
        categoryAdapter = CategoryChipAdapter { vm.selectCategory(it) }
        expensesAdapter = ExpensesAdapter()
        binding.rvCategoryFragmentList.adapter = categoryAdapter
        binding.rvExpenseFragmentList.adapter = expensesAdapter

        // estado
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            vm.uiState.collect { st ->
                binding.groupEmpty.isVisible = st.noCategories
                categoryAdapter.submitList(st.categories)
                expensesAdapter.submitList(st.expenses)
                binding.tvTotalExpensesFragmentList.text = st.total.centsToCurrency()
            }
        }

        if (args.openCategorySheet && savedInstanceState == null) {
            CreateCategoryBottomSheet().show(childFragmentManager, "category")
        }

        binding.btnAddExpenseFragmentList.setOnClickListener {
            AddExpenseBottomSheet().show(childFragmentManager, "add_expense")
        }
    }

    override fun onDestroyView() {
        _binding = null; super.onDestroyView()
    }
}