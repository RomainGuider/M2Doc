/*******************************************************************************
 *  Copyright (c) 2016 Obeo. 
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *   
 *   Contributors:
 *       Obeo - initial API and implementation
 *  
 *******************************************************************************/
package org.obeonetwork.m2doc.provider.configuration;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.obeonetwork.m2doc.genconf.Generation;
import org.obeonetwork.m2doc.generator.DocumentGenerator;
import org.obeonetwork.m2doc.generator.TemplateGenerator;
import org.obeonetwork.m2doc.properties.TemplateInfo;
import org.obeonetwork.m2doc.template.DocumentTemplate;

/**
 * Provider for pre and post configuration operations.
 * - configuration model creation
 * - template validation
 * - template generation
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public interface IConfigurationProvider {

    /**
     * Post operation after configuration model creation.
     * 
     * @param templateInfo
     *            TemplateInfo
     * @param templateFile
     *            IFile
     * @param generation
     *            Generation
     */
    void postCreateConfigurationModel(TemplateInfo templateInfo, IFile templateFile, Generation generation);

    /**
     * Pre operation before configuration model creation.
     * 
     * @param templateInfo
     *            TemplateInfo
     * @param templateFile
     *            IFile
     */
    void preCreateConfigurationModel(TemplateInfo templateInfo, IFile templateFile);

    /**
     * Post operation after template validation.
     * 
     * @param templateFile
     *            IFile
     * @param template
     *            DocumentTemplate
     * @param generation
     *            Generation
     * @param generator
     *            TemplateGenerator
     * @return validation result, must return true by default.
     */
    boolean postValidateTemplate(IFile templateFile, DocumentTemplate template, Generation generation,
            TemplateGenerator generator);

    /**
     * Pre operation before template validation.
     * 
     * @param templateFile
     *            IFile
     * @param template
     *            DocumentTemplate
     * @param generation
     *            Generation
     */
    void preValidateTemplate(IFile templateFile, DocumentTemplate template, Generation generation);

    /**
     * Pre operation before generation.
     * 
     * @param generation
     *            Generation
     * @param project
     *            IProject
     * @param templateFile
     *            IFile
     * @param generatedFile
     *            IFile
     */
    void preGenerate(Generation generation, IProject project, IFile templateFile, IFile generatedFile);

    /**
     * Post operation after generation.
     * 
     * @param generation
     *            Generation
     * @param project
     *            IProject
     * @param templateFile
     *            IFile
     * @param generatedFile
     *            IFile
     * @param template
     *            DocumentTemplate
     * @param generator
     *            DocumentGenerator
     * @return IFile list to return after the generation. Generation result and validation log are already in there.
     */
    List<IFile> postGenerate(Generation generation, IProject project, IFile templateFile, IFile generatedFile,
            DocumentTemplate template, DocumentGenerator generator);

}
