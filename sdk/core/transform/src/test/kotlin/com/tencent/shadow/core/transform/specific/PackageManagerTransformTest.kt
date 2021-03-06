/*
 * Tencent is pleased to support the open source community by making Tencent Shadow available.
 * Copyright (C) 2019 THL A29 Limited, a Tencent company.  All rights reserved.
 *
 * Licensed under the BSD 3-Clause License (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *     https://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.tencent.shadow.core.transform.specific

import com.tencent.shadow.core.transform_kit.AbstractTransformTest
import javassist.CtClass
import javassist.CtMethod
import org.junit.Assert.assertTrue
import org.junit.Test

class PackageManagerTransformTest : AbstractTransformTest() {

    val packageManagerClazz = sLoader["android.content.pm.PackageManager"]

    @Test
    fun testPackageManagerTransform() {
        val allInputClass = setOf(sLoader["test.TestPackageManager"], sLoader["test.TestPackageManager$1"], sLoader["test.TestPackageManager$1$1"])

        val packageManagerTransform = PackageManagerTransform()
        packageManagerTransform.mClassPool = sLoader
        packageManagerTransform.setup(allInputClass)

        val methods = arrayOf("getApplicationInfo","getActivityInfo")


        allInputClass.forEach {
            for (method in methods) {
                beforeTransformCheck(it, method)
            }
        }



        packageManagerTransform.list.forEach { transform ->
            transform.filter(allInputClass).forEach {
                it.defrost()
                transform.transform(it)
                it.writeFile(WRITE_FILE_DIR)
            }
        }



        allInputClass.forEach {
            for (method in methods) {
                afterTransformCheck(it, method)
            }
        }


    }


    fun beforeTransformCheck(clazz: CtClass, method: String) {
        val getApplicationMethods = packageManagerClazz.getDeclaredMethods(method)

        assertTrue("transform ?????????????????????PackageManager???" + method + "?????????",
                findCall(getApplicationMethods, clazz)
        )
    }


    fun afterTransformCheck(clazz: CtClass, method: String) {
        val getManagerMethods = packageManagerClazz.getDeclaredMethods(method)

        assertTrue("transform ???????????????????????????PackageManager???" + method + "?????????",
                !findCall(getManagerMethods, clazz)
        )


        val methods2: List<CtMethod> = getTargetMethods(sLoader, arrayOf(clazz.name), arrayOf(method + "_shadow"))

        assertTrue(method + "_shadow?????????????????????,?????????????????????",
                methods2.size == 1
        )

        assertTrue(method + "_shadow?????????????????????????????????",
                findCall(arrayOf(clazz.getDeclaredMethod(method + "_shadow")), clazz)
        )
    }

    fun findCall(target: Array<CtMethod>, clazz: CtClass): Boolean {
        clazz.defrost()
        var isFind = false
        for (methods in target) {
            if (matchMethodCallInClass(methods, clazz)) {
                isFind = true
                break
            }
        }
        return isFind
    }


}