/*
 * Copyright 2008-present MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.db.mongo.pojo.impl.fallback;

import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PropertyCodecProvider;
import org.bson.codecs.pojo.PropertyCodecRegistry;
import org.bson.codecs.pojo.TypeWithTypeParameters;
/**
 * @author linjianghua
 * @date 2021/06/13 16:07
 * @desc
 */
public class FallbackPropertyCodecProvider implements PropertyCodecProvider {

    private final CodecRegistry codecRegistry;

    public FallbackPropertyCodecProvider(final CodecRegistry codecRegistry) {
        this.codecRegistry = codecRegistry;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <S> Codec<S> get(final TypeWithTypeParameters<S> type, final PropertyCodecRegistry propertyCodecRegistry) {
        return codecRegistry.get(type.getType());
    }
}
