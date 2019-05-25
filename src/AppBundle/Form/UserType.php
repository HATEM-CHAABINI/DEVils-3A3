<?php

namespace AppBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class UserType extends AbstractType
{
    /**
     * {@inheritdoc}
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder->add('locked')->add('expired')->add('expiresAt')->add('credentialsExpired')->add('credentialsExpireAt')->add('departement')->add('qr')->add('image')->add('nom')->add('prenom')->add('ville')->add('dateNaissance')->add('bio')->add('domaine')->add('note')->add('adresse')->add('codePostal')->add('sexe')->add('telephone')->add('cin');
    }/**
     * {@inheritdoc}
     */
    public function configureOptions(OptionsResolver $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'AppBundle\Entity\User'
        ));
    }

    /**
     * {@inheritdoc}
     */
    public function getBlockPrefix()
    {
        return 'appbundle_user';
    }


}
