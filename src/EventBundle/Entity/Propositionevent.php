<?php

namespace EventBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Propositionevent
 *
 * @ORM\Table(name="propositionevent")
 * @ORM\Entity
 */
class Propositionevent
{
    /**
     * @var integer
     *
     * @ORM\Column(name="idPEvent", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idpevent;

    /**
     * @var string
     *
     * @ORM\Column(name="typeEvent", type="string", length=255, nullable=false)
     */
    private $typeevent;

    /**
     * @var string
     *
     * @ORM\Column(name="description", type="string", length=255, nullable=false)
     */
    private $description;

    /**
     * @var string
     *
     * @ORM\Column(name="titre", type="string", length=255, nullable=false)
     */
    private $titre;

    /**
     * @var string
     *
     * @ORM\Column(name="etat", type="string", length=255, nullable=false)
     */
    private $etat;

    /**
     * @var string
     *
     * @ORM\Column(name="username", type="string", length=255, nullable=false)
     */
    private $username;



    /**
     * Get idpevent
     *
     * @return integer
     */
    public function getIdpevent()
    {
        return $this->idpevent;
    }

    /**
     * Set typeevent
     *
     * @param string $typeevent
     *
     * @return Propositionevent
     */
    public function setTypeevent($typeevent)
    {
        $this->typeevent = $typeevent;

        return $this;
    }

    /**
     * Get typeevent
     *
     * @return string
     */
    public function getTypeevent()
    {
        return $this->typeevent;
    }

    /**
     * Set description
     *
     * @param string $description
     *
     * @return Propositionevent
     */
    public function setDescription($description)
    {
        $this->description = $description;

        return $this;
    }

    /**
     * Get description
     *
     * @return string
     */
    public function getDescription()
    {
        return $this->description;
    }

    /**
     * Set titre
     *
     * @param string $titre
     *
     * @return Propositionevent
     */
    public function setTitre($titre)
    {
        $this->titre = $titre;

        return $this;
    }

    /**
     * Get titre
     *
     * @return string
     */
    public function getTitre()
    {
        return $this->titre;
    }

    /**
     * Set etat
     *
     * @param string $etat
     *
     * @return Propositionevent
     */
    public function setEtat($etat)
    {
        $this->etat = $etat;

        return $this;
    }

    /**
     * Get etat
     *
     * @return string
     */
    public function getEtat()
    {
        return $this->etat;
    }

    /**
     * Set username
     *
     * @param string $username
     *
     * @return Propositionevent
     */
    public function setUsername($username)
    {
        $this->username = $username;

        return $this;
    }

    /**
     * Get username
     *
     * @return string
     */
    public function getUsername()
    {
        return $this->username;
    }
}
