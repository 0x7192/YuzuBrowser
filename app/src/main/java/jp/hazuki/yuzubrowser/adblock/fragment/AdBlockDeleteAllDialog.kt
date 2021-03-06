/*
 * Copyright (C) 2017 Hazuki
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.hazuki.yuzubrowser.adblock.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import jp.hazuki.yuzubrowser.R

class AdBlockDeleteAllDialog : DialogFragment() {

    private var listener: OnDeleteAllListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(activity)
                .setTitle(R.string.pref_delete_all)
                .setMessage(R.string.pref_delete_all_confirm)
                .setPositiveButton(android.R.string.yes) { _, _ -> listener!!.onDeleteAll() }
                .setNegativeButton(android.R.string.cancel, null)
                .create()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = parentFragment as OnDeleteAllListener
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    internal interface OnDeleteAllListener {
        fun onDeleteAll()
    }
}
